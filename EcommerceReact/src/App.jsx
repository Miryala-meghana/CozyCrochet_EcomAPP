import { useState, useEffect } from "react";
import './App.css'
import ProductList from "./ProductList";
import CategoryFilter from "./CategoryFilter";
import { API_URL } from "./config";

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOption, setSortOption] = useState("asc");
  const [theme, setTheme] = useState("dark");
  // True until the products request finishes (the free backend can take ~1 min to wake up)
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    document.body.className = theme;
  }, [theme]);

  useEffect(() => {
    fetch(API_URL + '/api/products')
      .then(response => response.json())
      .then(data => setProducts(data))
      .finally(() => setLoading(false));

    fetch(API_URL + '/api/categories')
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

const toggleTheme = () => {
  const newTheme = theme === "light" ? "dark" : "light";
  setTheme(newTheme);
  document.body.className = newTheme;
};
  return (
  <div className={theme}>
    <div className="container">

      <div className="my-4 d-flex justify-content-between align-items-center">
        <h1 className="app-heading">Cozy Crochet</h1>

        <button className="btn btn-secondary theme-btn" onClick={toggleTheme}>
          {theme === "light" ? "Dark Mode" : "Light Mode"}
        </button>
      </div>

      <div className="row align-items-center mb-4">
        <div className="col-md-3 col-sm-12 mb-2">
          <CategoryFilter categories={categories} onSelect={handleCategorySelect} />
        </div>

        <div className="col-md-5 col-sm-12 mb-2">
          <input
            type="text"
            className="form-control"
            placeholder="Search products..."
            onChange={handlesearchTermChange}
          />
        </div>

        <div className="col-md-4 col-sm-12 mb-2">
          <select className="form-control" onChange={handleSortChange}>
            <option value="asc">Price: Low to High</option>
            <option value="desc">Price: High to Low</option>
          </select>
        </div>
      </div>

      <div>
        {loading ? (
          <p>Loading products...</p>
        ) : filteredProducts.length ? (
          <ProductList products={filteredProducts} />
        ) : (
          <p>products not found...</p>
        )}
      </div>

    </div>
  </div>
)
}

export default App
