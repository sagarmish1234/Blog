import React from "react";
import "./sideEditorPick.css";

function SideEditorPick({ image, story, title, category }) {
  return (
    <div className="sideEditorPickContainer">
      <img src={image} alt="" className="sideEditorPickImage" />
      <div className="sideEditorPickContent">
        <div className="sideEditorPickContentTitle">
          <div className="sideEditorPickContentCategory">{category}</div>
          {title}
        </div>
        <div className="sideEditorPickContentStory">
          {story.split(".")[0]}
        </div>
      </div>
    </div>
  );
}

export default SideEditorPick;
