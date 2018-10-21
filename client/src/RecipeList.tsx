import * as React from 'react';
import './styles/RecipeList.css';

import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';

function RecipeList(props: any) {
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
        recipes.map((recipe, i) => (
            <Card key={i} className="recipe-card">
                <CardContent>
                    <Typography variant="h5" component="h2">
                        {recipe.name}
                    </Typography>
                    <Typography className="pos" color="textSecondary">
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

export default RecipeList as any;
