import * as React from 'react';

import { withStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';

const styles = {
    card: {
      minWidth: 275,
    },
    bullet: {
      display: 'inline-block',
      margin: '0 2px',
      transform: 'scale(0.8)',
    },
    title: {
      fontSize: 14,
    },
    pos: {
      marginBottom: 12,
    },
};

function RecipeList(props: any) {
    const { classes } = props;
    const recipes = [
        { name: 'Recipe 1', style: 'IPA' },
        { name: 'Recipe 2', style: 'Scotch Ale' },
        { name: 'Recipe 3', style: 'Barley Wine' },
        { name: 'Recipe 4', style: 'Stout' },
        { name: 'Recipe 5', style: 'Porter' },
        { name: 'Recipe 6', style: 'Pilsner' },
        { name: 'Recipe 7', style: 'EPA' },
        { name: 'Recipe 8', style: 'Black IPA' },
        { name: 'Recipe 9', style: 'Gose' },
        { name: 'Recipe 10', style: 'Pumpkin Ale' }
    ];

    return (
        recipes.map((recipe) => (
            <Card className={classes.card}>
                <CardContent>
                    <Typography variant="h5" component="h2">
                        {recipe.name}
                    </Typography>
                    <Typography className={classes.pos} color="textSecondary">
                        style
                    </Typography>
                    <Typography component="p">
                        {recipe.style}
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="small">Details</Button>
                </CardActions>
            </Card>
        ))
    );
}

export default withStyles(styles)(RecipeList as any);
