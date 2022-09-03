import React, { useEffect, useState } from 'react'
import baseUrl from "../../config/BaseUrl"

function Categories() {

const [category, setCategories] = useState(false);

useEffect(() => {
    const categories = async () => {
        const response = await fetch(`${baseUrl}/category/getAll`, {method: "GET"});
        if(response.status === 200) {
            const data = await response.json();
            setCategories(data);
        } 
    };
    categories();
}, [])

  return (
    <div>
        {category.map((category) => (
             <p key={category.id}>{category.name}</p>
        ))}
    </div>
  )
}

export default Categories