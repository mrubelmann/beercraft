import * as React from 'react';
import '../styles/App.css';

import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import RecipeList from './RecipeList';
import Recipe from 'src/Recipe';

interface AppProps {
    recipes: Recipe[];
}

class App extends React.Component<AppProps, any> {
    public constructor(props: AppProps) {
        super(props);
    }

    public render() {
        return (
            <div className="root">
                <AppBar position="sticky" color="default">
                    <Toolbar>
                        <Typography variant="h6" color="inherit">
                            Beercraft
                        </Typography>
                    </Toolbar>
                </AppBar>
                <RecipeList recipes={this.props.recipes} />
            </div>
        );
    }
}

export default App;
