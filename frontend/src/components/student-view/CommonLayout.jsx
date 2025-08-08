import React from 'react'
import { Outlet } from 'react-router-dom'
import StudentViewHeader from './Header'
import StudentHomepage from '@/pages/student/home'

export default function StudentViewLayout() {
  return (
    <div>
      <StudentViewHeader/>
      <StudentHomepage/>
      <Outlet/>
    </div>
  )
}
