import { useState, useEffect } from "react";
import './App.css'
import ProductList from "./ProductList";
import CategoryFilter from "./CategoryFilter";

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOption, setSortOption] = useState("asc");
   
  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setProducts(data));

    fetch('http://localhost:8080/api/categories')
      .then(response => response.json())
      .then(data => setCategories(data));
  }, []);
const handlesearchTermChange = (e) => {
  setSearchTerm(e.target.value);
}

const handleSortChange = (e) => {
  setSortOption(e.target.value);
}

const handleCategorySelect = (categoryId) => {
  setSelectedCategory(categoryId?Number(categoryId):null);
}

const filteredProducts = products
  .filter(product =>{
    return(
      (selectedCategory ? product.category.id === selectedCategory : true) 
      &&
      (product.name.toLowerCase().includes(searchTerm.toLowerCase()) )
    )
  }).sort((a,b) => {
    if(sortOption === "asc"){
      return a.price - b.price;
    }else{
      return b.price - a.price;
    }
  });


  return (
    <div className='container'>
      <div className="my-4"><h1>product catalog</h1></div>
      <div className='row align-items-center mb-4'>
        <div className='col-md-3 col-sm-12 mb-2'>
          <CategoryFilter categories={categories} onSelect={handleCategorySelect} />
        </div>
        <div className='col-md-5 col-sm-12 mb-2'>
          <input
            type="text"
            className='form-control'
            placeholder='Search products...'
            onChange={handlesearchTermChange}
          />
        </div>
        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option value="asc">Price: Low to High</option>
            <option value="desc">Price: High to Low</option>
          </select>
        </div>

      </div>  


      <div>
        {filteredProducts.length ? (
          //display products
          <ProductList products={filteredProducts} />
        ):(
          <p>products not found...</p>
        )}
      </div>
      
    </div>
  )
}

export default App
