import React from 'react'
import "./trendingPost.css"
function TrendingPost({id,title,createdAt, wordCount, rank,image}) {
  return (
    <div className="trendingPostContainer">
      <div className="trendingPostRank">{rank}</div>
      <div className="trendingPostAuthor">
        <img src={image} alt="" className="trendingPostAuthorPic" />
        <div className="trendingPostAuthorName">Sagar</div>
      </div>
    </div>
  )
}

export default TrendingPost