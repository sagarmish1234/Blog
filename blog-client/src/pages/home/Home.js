import React, { useContext, useEffect } from "react";
import "./home.css";
import Image from "../../assests/images/dark-image.webp";
import Typed from "typed.js";
import EditorPick from "../../component/editorPick/EditorPick";
import { motion } from "framer-motion";
import { width } from "@mui/system";
import { duration } from "@mui/material";

import Categories from "../categories/Categories";
import { useLocation, useNavigate } from "react-router-dom";

function Home() {
  var options = {
    strings: ["<i>First</i> sentence.", "&amp; a second sentence."],
    typeSpeed: 40,
  };

  useEffect(() => {
    var temp = new Typed("#typewriter", {
      strings: [
        "Passion",
        "Determination",
        "Curiosity",
        "Achievement",
        "Appreciation",
      ],
      typeSpeed: 100,
      loop: true,
      backSpeed: 100,
    });
    return () => {
      clearInterval(temp);
    };
  }, []);

  return (
    <div className="homeContainer">
      <img src={Image} className="homePageImage" />
      <div className="darkend-image">
        <div className="homeTitle">
          <div className="homeTitleHeader">
            Write for <span id="typewriter"></span>
          </div>
          You don’t start out writing good stuff. You start out writing crap and
          thinking it’s good stuff, and then gradually you get better at it.
          That’s why the most valuable trait is persistence.
        </div>
      </motion.div>
      <Categories />
      </div>
      <EditorPick></EditorPick>
    </div>
  );
}

export default Home;
