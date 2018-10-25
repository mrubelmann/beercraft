import * as React from 'react';
import RecipeCard from './RecipeCard';

import '../styles/RecipeList.css';

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
            <div key={i} className="recipe-list-item">
                <RecipeCard name={recipe.name} style={recipe.style} />
            </div>
        ))
    );
}

export default RecipeList as any;
