import React from 'react'
import "./formError.css"
function FormError({theme,message}) {
  return (
    <div className={theme}>{message}</div>
  )
}

export default FormError