import React from 'react';

import {ItemComponent} from './components';
import axios, {AxiosResponse} from "axios";
import {Item} from "./model/item";

interface IProps {

}

interface IState {
  items: Item[]
}

class App extends React.Component<IProps, IState> {

  public state: IState = {
    items: []
  };

  public componentDidMount(): void {
    axios.get<Item[]>('/api/v1/items').then((response: AxiosResponse<Item[]>) => {
      const items: Item[] = response.data;
      this.setState({
        items: items
      });
    });
  }

  render() {
    const {items} = this.state;

    return (
      <div className="App">
        {(items.map(item => <ItemComponent key={item.id} item={item}/>))}
      </div>
    );
  }
}

export default App;
