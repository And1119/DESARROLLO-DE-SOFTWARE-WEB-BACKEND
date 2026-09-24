const express = require('express');
const cors = require('cors');
const path = require('path');

const app = express();
const PORT = 3000;

app.use(cors());
app.use(express.static(__dirname));

// Ruta principal para servir el HTML
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

// Endpoint para el JSON
app.get('/api/productos-json', (req, res) => {
  res.sendFile(path.join(__dirname, 'productos.json'));
});

// Endpoint para el XML
app.get('/api/productos-xml', (req, res) => {
  res.type('application/xml');
  res.sendFile(path.join(__dirname, 'productos.xml'));
});

app.listen(PORT, () => {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});