import React from 'react';
import {Item} from '../../model';
import './index.css';

interface IProps {
  item: Item
}

class ItemComponent extends React.Component<IProps> {

  public render() {
    const {item} = this.props;
    const completed = new Date(item.completed);

    return <div className="panel">
      <div className="panel-body">
        <div className="header">
          <div className="title">{item.name}</div>
        </div>
        <div className="body">
          {item.notes}
        </div>
        <div className="footer">
          Grading Completed: {(completed.getMonth() + 1) + "/" + completed.getDate() + "/" + completed.getFullYear()}
        </div>
      </div>
      <div className="grade">{item.grade ? item.grade : "N/A"}</div>
    </div>;
  }

}

export default ItemComponent;