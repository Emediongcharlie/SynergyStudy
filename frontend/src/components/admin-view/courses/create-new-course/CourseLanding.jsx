import FormControls from '@/components/forms/form-controls'
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card'
import { courseLandingPageFormControls } from '@/config'
import { AdminContext } from '@/context/admin-context'
import React, { useContext } from 'react'

export default function CourseLanding() {

  const {courseLandingFormData, setCourseLandingFormData} = useContext(AdminContext)

  return (
    <Card>
      <CardHeader>
        <CardTitle>Course Landing Page</CardTitle>
      </CardHeader>
      <CardContent>
        <FormControls 
        formControls={courseLandingPageFormControls}
        formData={courseLandingFormData}
        setFormData={setCourseLandingFormData}
        />
      </CardContent>
    </Card>
  )
}
