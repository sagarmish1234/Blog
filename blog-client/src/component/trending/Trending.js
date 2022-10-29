import React, { useState } from "react";
import "./trending.css";
import articles from "../../assests/data/articles";
import TrendingPost from "./trendingPost/TrendingPost";
import {FaChartLine} from "react-icons/fa"
function Trending() {
  const [trendingArticles, setTrendingArtilces] = useState(
    articles.slice(0, 9)
  );

  return (
    <div className="trendingContainer">
      <div className="trendingContainerTitle"><FaChartLine className="trendingIcon"></FaChartLine> Trending on Skrive</div>
      <div className="trendingPostsContainer">
        {trendingArticles &&
          trendingArticles.map((e,rank) => <TrendingPost {...e} rank={rank}></TrendingPost>)}
      </div>
    </div>
  );
}

export default Trending;
