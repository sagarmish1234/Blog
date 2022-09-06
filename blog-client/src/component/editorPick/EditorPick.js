import React, { useState, useEffect } from "react";
import "./editorPick.css";
import SubdirectoryArrowRightSharp from "@mui/icons-material/SubdirectoryArrowRightSharp";
import SideEditorPick from "../sideEditorPick/SideEditorPick";
import Image from "../../assests/images/editor-pick.webp";
import { motion } from "framer-motion";

function EditorPick({data, title}) {
  // const [editorPics, setEditorPicks] = useState([
  //   {
  //     image: Image,
  //     title: "This is title 1",
  //     story:
  //       "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veritatis quod quibusdam nulla possimus. Reprehenderit, aperiam. Quos provident ad odit aliquid?",
  //   },
  //   {
  //     image: Image,
  //     title: "This is title 2",
  //     story:
  //       "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veritatis quod quibusdam nulla possimus. Reprehenderit, aperiam. Quos provident ad odit aliquid?",
  //   },
  //   {
  //     image: Image,
  //     title: "This is title 3",
  //     story:
  //       "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veritatis quod quibusdam nulla possimus. Reprehenderit, aperiam. Quos provident ad odit aliquid?",
  //   },
  //   {
  //     image: Image,
  //     title: "This is title 4",
  //     story:
  //       "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veritatis quod quibusdam nulla possimus. Reprehenderit, aperiam. Quos provident ad odit aliquid?",
  //   },
  // ]);


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
          margin: "-120px",
        }}
      >
        {title}
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
          margin: "-260px",
        }}
        className="editorContent"
      >
        <div className="editorContentLeft">
          <img src={data[0].image} alt="" className="editorContentImage" />
          <div className="editorCard">
            <div className="editorCardTitle">
              <span className="editorCardCategory">{data[0].category}</span> {data[0].title}
            </div>
            <div className="editorCardFooter">
              <div className="editorCardReadTime">3 min Read</div>
            </div>
          </div>
        </div>
        <div className="editorContentRight">
          {data.slice(1).map((ele, index) => (
            <SideEditorPick
              key={index}
              image={ele.image}
              title={ele.title}
              story={ele.story}
              category={ele.category}
            />
          ))}
        </div>
      </motion.div>
    </div>
  );
}

export default EditorPick;
