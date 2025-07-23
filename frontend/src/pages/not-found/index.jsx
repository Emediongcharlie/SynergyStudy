import React from 'react'

export default function NotFound() {
  return (
    <div>
      <h1>404 - Page Not Found</h1>
      <p>The page you are looking for does not exist.</p>
      <a href="/" className='text-blue-600 underline hover:text-red-800 ' >Go back to Home</a>
    </div>
  )
}
