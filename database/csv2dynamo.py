import argparse
import json


def get_columns(line):
    line = line.strip('\n')
    if len(line) == 0:
        return None

    curr = ''
    columns = []

    for x in line.split(','):
        if x.startswith('"'):
            curr = x[1:]

        if x.endswith('"'):
            x = curr + ',' + x[:-1]
            curr = ''

        if curr == '':
            columns.append(x)

    return columns


def get_types(values):
    types = []
    for x in values:
        if x.lower() == 'true' or x.lower() == 'false':
            types.append('BOOL')
        elif x.isnumeric():
            types.append('N')
        else:
            types.append('S')

    return types


def format_item(names, types, values):
    item = {}
    for i in range(len(names)):
        value = values[i]
        if value.lower() == 'true':
            value = True
        elif value.lower() == 'false':
            value = False

        if value != '':
            item[names[i]] = {types[i]: value}

    return {'PutRequest': {'Item': item}}


if __name__ == '__main__':
    parser = argparse.ArgumentParser(formatter_class=argparse.RawDescriptionHelpFormatter, description=
'''Converts a CSV into JSON that can be ingested by DynamoDB. To upload the
results, use the AWS CLI tools as follows:

    aws dynamodb batch-write-item --request-items file://<filename>.json)''')
    parser.add_argument('-t', '--table', default="Beercraft", required=False, help='The table name')
    parser.add_argument('-c', '--csvFile', required=True, type=argparse.FileType('r'), help='The CSV file to convert')
    parser.add_argument('-o', '--output', required=True, help='The base name for the output files')
    args = parser.parse_args()

    with args.csvFile as file:
        # The first line should have the attribute names.
        names = get_columns(file.readline())

        # Deduce the types from the second line.
        line = file.readline()
        values = get_columns(line)
        types = get_types(values)

        # Turn each line into an appropriately-formatted dictionary.
        items = []
        while line:
            values = get_columns(line)
            items.append(format_item(names, types, values))
            line = file.readline()

        #  They need to be grouped into batches of 25.
        groups = [items[i:i+25] for i in range(0, len(items), 25)]

        # Last but not least, save the JSON.
        for i in range(len(groups)):
            with open('{}_{}.json'.format(args.output, i+1), 'w') as output:
                output.write(json.dumps({args.table: groups[i]}, indent=4))

