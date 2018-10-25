import * as React from 'react';
import * as ReactDOM from 'react-dom';
import App from './components/App';
import './styles/index.css';
import registerServiceWorker from './registerServiceWorker';

const testRecipes = [
    { name: 'Recipe 1' },
    { name: 'Recipe 2' },
    { name: 'Recipe 3' },
    { name: 'Recipe 4' },
    { name: 'Recipe 5' },
    { name: 'Recipe 6' },
    { name: 'Recipe 7' },
    { name: 'Recipe 8' },
    { name: 'Recipe 9' },
    { name: 'Recipe 10' }
];
  
ReactDOM.render(
    <App recipes={testRecipes} />,
    document.getElementById('root') as HTMLElement
);
registerServiceWorker();
