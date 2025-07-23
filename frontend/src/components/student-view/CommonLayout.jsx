import React from 'react'
import { Outlet } from 'react-router-dom'

export default function StudentViewLayout() {
  return (
    <div>Student 
      <Outlet/>
    </div>
  )
}
