import React from "react";
import FormControls from "./form-controls";
import { Button } from "../ui/button";

export default function CommonForm({
  handleSubmit,
  buttonText,
  formControls = [],
  formData,
  setFormData,
  isButtonDisabled = false,
}) {
  return (
    <form onSubmit={handleSubmit}>
      {/* render form controls */}
      <FormControls
        formControls={formControls}
        formData={formData}
        setFormData={setFormData}
      />
      <Button disabled={isButtonDisabled} type="submit" className={"mt-5 w-full"}>
        {buttonText || "Submit"}
      </Button>
    </form>
  );
}
