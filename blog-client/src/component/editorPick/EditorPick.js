import React, { useState } from "react";
import "./editorPick.css";
import SubdirectoryArrowRightSharp from "@mui/icons-material/SubdirectoryArrowRightSharp";
import SideEditorPick from "../sideEditorPick/SideEditorPick";

function EditorPick() {
  const [editorPics, setEditorPicks] = useState([{
    image:"image",
    title:"title",
    story:"story"
  },{
    image:"image",
    title:"title",
    story:"story"
  },{
    image:"image",
    title:"title",
    story:"story"
  }]);

  return (
    <div className="editorcontainer">
      <div className="editorTitle">
        Skrive's Picks
        <div className="editorExplore">
          <SubdirectoryArrowRightSharp></SubdirectoryArrowRightSharp> Explore
        </div>
      </div>
      <div className="editorContent">
        <div className="editorContentLeft">
          <img src="" alt="" className="editorContentImage" />
          <div className="editorCard">
            <div className="editorCardTitle">
              <span className="editorCardCaterory">Category</span>This is a very
              big title
            </div>
            <div className="editorCardFooter">
              <div className="editorCardReadTime">3 min Read</div>
            </div>
          </div>
        </div>
        <div className="editorContentRight">
          {editorPics.slice(1).map((ele, index) => (
            <SideEditorPick
              key={index}
              image={ele.image}
              title={ele.title}
              story={ele.story}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default EditorPick;
