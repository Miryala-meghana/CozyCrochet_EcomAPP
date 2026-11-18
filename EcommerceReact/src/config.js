// Backend address: set VITE_API_URL on Render; falls back to the local backend
export const API_URL = import.meta.env.VITE_API_URL || "http://localhost:8080";
