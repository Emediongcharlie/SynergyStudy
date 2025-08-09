import React, { useState } from 'react'
import ReactPlayer from 'react-player'

export default function VideoPlayer({width = '100%', height= '100%', url}) {

  

  return (
    <div>
      <ReactPlayer width={'100%'} height={'100%'} url={url} ></ReactPlayer>
    </div>
  )
}
