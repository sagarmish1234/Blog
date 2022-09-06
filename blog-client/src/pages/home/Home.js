import React, { useContext, useEffect ,useState} from "react";
import "./home.css";
import Image from "../../assests/images/dark-image.webp";
import Typed from "typed.js";
import EditorPick from "../../component/editorPick/EditorPick";
import { motion } from "framer-motion";
import { width } from "@mui/system";
import { duration } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import axios, {AbortController} from "axios"
import baseUrl from "../../config/BaseUrl";

function Home() {

  const [data,setData] = useState(null);

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


  const fectchApi = async ()=>{
    const response = await axios.get(`${baseUrl}/article/getEditorPics`);
    console.log(response)
    setData(response.data)
  }

  useEffect(() =>  {
    // const controller = new AbortController();
    fectchApi()
    return () => {
      // controller.abort()
    }
  }, [])
  

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
      </div>
      {/* <EditorPick title={"Trending Picks"}></EditorPick> */}
      {data && <EditorPick title={"Editor's Pick"} data={data}></EditorPick>}
    </div>
  );
}

export default Home;
