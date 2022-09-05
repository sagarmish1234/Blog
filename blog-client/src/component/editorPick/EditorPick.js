import React, { useState } from "react";
import "./editorPick.css";
import SubdirectoryArrowRightSharp from "@mui/icons-material/SubdirectoryArrowRightSharp";
import SideEditorPick from "../sideEditorPick/SideEditorPick";
import Image from "../../assests/images/editor-pick.webp";
import { motion } from "framer-motion";

function EditorPick() {
  const [editorPics, setEditorPicks] = useState([
    {
      image: Image,
      title: "This is title 1",
      story: "This is story 1",
    },
    {
      image: Image,
      title: "This is title 2",
      story: "This is story 2",
    },
    {
      image: Image,
      title: "This is title 3",
      story: "This is story 3",
    },
    {
      image: Image,
      title: "This is title 4",
      story: "This is story 4",
    },
  ]);

  return (
    <div className="editorContainer">
      <motion.div
        className="editorTitle"
        initial={{
          opacity: 0,
          translateY: 100,
        }}
        whileInView={{
          opacity: 1,
          translateY: 0,
          transition: {
            duration: 1,
          },
        }}
        viewport={{
          once: true,
          margin: "-200px",
        }}
      >
        Trending Picks
        <div className="editorExplore">
          <SubdirectoryArrowRightSharp></SubdirectoryArrowRightSharp> Explore
        </div>
      </motion.div>
      <motion.div
        initial={{
          opacity: 0,
          translateY: 100,
        }}
        whileInView={{
          opacity: 1,
          translateY: 0,
          transition: {
            duration: 1,
          },
        }}
        viewport={{
          once: true,
          margin: "-320px",
        }}
        className="editorContent"
      >
        <div className="editorContentLeft">
          <img src={Image} alt="" className="editorContentImage" />
          <div className="editorCard">
            <div className="editorCardTitle">
              <span className="editorCardCategory">Category</span> 4 Of The Most
              Luxurious Hotels in India
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
              category={"Travel"}
            />
          ))}
        </div>
      </motion.div>
    </div>
  );
}

export default EditorPick;
