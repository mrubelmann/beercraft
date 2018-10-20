import * as React from 'react';

import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import RecipeList from './RecipeList';

class App extends React.Component {
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
        <RecipeList />
      </div>
    );
  }
}

export default App;
