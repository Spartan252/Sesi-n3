

const productsList = [];

function getProducts() {
  return productsList;
}

function getProductById(uuid) {
  return productsList.find(product => product.uuid === uuid);
}

function createProduct(product) {
  productsList.push(product);
}

function updateProduct(uuid, updatedProduct) {
  const index = productsList.findIndex(product => product.uuid === uuid);
  if (index !== -1) {
    productsList[index] = { ...productsList[index], ...updatedProduct };
  }
}

function deleteProduct(uuid) {
  const index = productsList.findIndex(product => product.uuid === uuid);
  if (index !== -1) {
    productsList.splice(index, 1);
  }
}

function findProduct(query) {
  const [category, title] = query.split(':').map(part => part.trim());
  if (category && title) {
    return productsList.filter(product => product.category.includes(category) && product.title.includes(title));
  } else if (category) {
    return productsList.filter(product => product.category.includes(category));
  } else if (title) {
    return productsList.filter(product => product.title.includes(title));
  }
  return [];
}



