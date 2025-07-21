export const registerFormControls = [
  {
    name: 'fullname', 
    type: 'text',
    placeholder: 'Full Name',
    componentType: 'input',
  },
  {
    name: 'email',
    type: 'email',
    placeholder: 'Email',
    componentType: 'input', 
  },
  {
    name: 'password',
    type: 'password',
    placeholder: 'Password',
    componentType: 'input', 
  }
]

export const loginFormControls = [
  {
    name: 'email',
    type: 'email',
    placeholder: 'Email',
    componentType: 'input', 
  },
  {
    name: 'password',
    type: 'password',
    placeholder: 'Password',
    componentType: 'input', 
  }
]

export const initialLoginFormData = {
  email: '',
  password: '',
}
export const initialRegisterFormData = {
  fullname: "",
  email: "",
  password: "",
};