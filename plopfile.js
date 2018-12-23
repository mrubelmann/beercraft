function getRequestHandlerName(answers) {
    return getRequestClassBaseName(answers) + 'RequestHandler';
}

function getRequestWorkerName(answers) {
    return getRequestClassBaseName(answers) + 'RequestWorker';
}

function getRequestClassBaseName(answers) {
    const method = capitalize(answers['method']);

    const path = answers['path'];
    const words = getWordsFromPath(path);
    words[0] = makeSingular(words[0]);
    for(let i = 0; i < words.length; i++) {
        words[i] = capitalize(words[i]);
    }

    return method + words.join('');
}

function capitalize(word) {
    return word[0].toUpperCase() + word.slice(1).toLowerCase();
}

function makeSingular(word) {
    if(word.endsWith('s')) {
        return word.slice(0, -1);
    }

    return word;
}

function getWordsFromPath(path) {
    return path.split('/').filter((x) => x != '' && !x.startsWith('{'));
}

function getResource(answers) {
    const path = answers['path'];
    const resource = getWordsFromPath(path)[0];
    return resource.toLowerCase();
}

module.exports = function (plop) {
    // REST endpoint generator
    plop.setGenerator('endpoint', {
        description: 'a new request endpoint',
        prompts: [{
            type: 'list',
            name: 'method',
            choices: ['GET', 'POST', 'PUT', 'PATCH', 'DELETE'],
            message: 'HTTP method',
            filter: (x) => x.toUpperCase()
        },
        {
            type: 'input',
            name: 'path',
            message: 'Endpoint path',
            filter: (x) => { if(x.startsWith('/')) { return x.slice(1); } else { return x; } }
        },
        {
            type: 'input',
            name: 'requestHandler',
            message: 'Request handler class name',
            default: getRequestHandlerName
        },
        {
            type: 'input',
            name: 'requestWorker',
            message: 'Request worker class name',
            default: getRequestWorkerName
        }],
        actions: (answers) => {
            let actions = [];

            answers['package'] = getResource(answers);

            actions.push({
                type: 'add',
                path: `server/src/main/java/beercraft/${answers['package']}/${answers['requestHandler']}.java`,
                templateFile: 'plop-templates/RequestHandler.hbs'
            });

            actions.push({
                type: 'add',
                path: `server/src/main/java/beercraft/${answers['package']}/${answers['requestWorker']}.java`,
                templateFile: 'plop-templates/RequestWorker.hbs'
            });

            actions.push({
                type: 'modify',
                pattern: '# [NEW EVENTS GO HERE]',
                path: 'serverless.yml',
                template:
`   - http:
        path: {{path}}
        method: {{lowerCase method}}
# [NEW EVENTS GO HERE]`
            });

            return actions;
        }
    });
};
