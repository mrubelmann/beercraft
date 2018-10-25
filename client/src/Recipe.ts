import RecipeIngredient from './RecipeIngredient';

interface Recipe {

    // TODO: Make these all non-optional.
    id?: string;
    name: string;
    description?: string;
    fermentables?: RecipeIngredient[];
    hops?: RecipeIngredient[];
    extras?: RecipeIngredient[];
    yeast?: RecipeIngredient[];
    volume?: number;
    boilTime?: number;

}

export default Recipe;