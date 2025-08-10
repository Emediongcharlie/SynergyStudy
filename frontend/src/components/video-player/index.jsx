import React from "react";
import ReactPlayer from "react-player";

export default function VideoPlayer({ url }) {
  return (
    <div>
      <ReactPlayer
        className="absolute top-0 left-0"
        width={"100%"}
        height={"100%"}
        url={url}
        controls
      ></ReactPlayer>
    </div>
  );
}
