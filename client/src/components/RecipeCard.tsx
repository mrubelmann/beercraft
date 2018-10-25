import * as React from 'react';
import '../styles/RecipeCard.css';

import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';

interface RecipeCardProps {
    name: string;
    style: string;
}

function RecipeCard(props: RecipeCardProps) {
    return (
        <Card className="recipe-card">
            <CardContent>
                <Typography variant="h5" component="h2">
                    {props.name}
                </Typography>
                <Typography className="pos" color="textSecondary">
                    style
                </Typography>
                <Typography component="p">
                    {props.style}
                </Typography>
            </CardContent>
            <CardActions>
                <Button size="small">Details</Button>
            </CardActions>
        </Card>
    );
}

export default RecipeCard;
