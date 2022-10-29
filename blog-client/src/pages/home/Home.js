import React, { useContext, useEffect, useState } from "react";
import "./home.css";
import Image from "../../assests/images/dark-image.webp";
import EditorPick from "../../component/editorPick/EditorPick";
import axios from "axios";
import baseUrl from "../../config/BaseUrl";
import Trending from "../../component/trending/Trending";
import Hero from "../../component/hero/Hero";
function Home() {
  const [data, setData] = useState(null);

  const fectchApi = async (signal) => {
    const response = await axios.get(`${baseUrl}/article/getEditorPics`,{
      signal:signal
    });
    console.log(response);
    setData(response.data);
  };

  useEffect(() => {
    const controller = new AbortController();
    const signal = controller.signal;
    fectchApi(signal);
    return () => {
      controller.abort()
    };
  }, []);

  return (
    <div className="homeContainer">
      <Hero></Hero>
      <Trending></Trending>
      {/* {data && <EditorPick title={"Editor's Pick"} data={data}></EditorPick>} */}
    </div>
  );
}

export default Home;
