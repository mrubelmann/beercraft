import * as React from 'react';
import RecipeCard from './RecipeCard';
import Recipe from '../Recipe';

import '../styles/RecipeList.css';

interface RecipeListProps {
    recipes: Recipe[];
}

function RecipeList(props: RecipeListProps) {
    return (
        props.recipes.map((recipe, i) => (
            <div key={i} className="recipe-list-item">
                <RecipeCard name={recipe.name} style="IPA" />
            </div>
        ))
    );
}

export default RecipeList as any;
