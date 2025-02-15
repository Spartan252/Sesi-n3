//----------------------------------------------------------------------------------------------------------------------------
let url = "http://localhost:3000/products"


async function fetchProducts() {
    const res = await fetch(`${url}`, {
        method: "GET",
    });

    const products = await res.json();

    return products;
}
//---------------------------------------------------------------------
function renderProducts(page = 0, searchFilter = "") {
    let products = JSON.parse(sessionStorage.getItem("products"));

    if (searchFilter) {
        products = products.filter((product) =>
            product.name.toLowerCase().includes(searchFilter.toLowerCase())
        );
    }

    const pageSize = 4;
    const start = page * pageSize;
    const end = start + pageSize;

    products = products.slice(start, end);

    const html = products.map((product) => toCardComponent(product)).join("\n");

    render("products-row", html);
}

function searchHandler(event) {
    const searchFilter = event.target.value.trim();
    renderProducts(0, searchFilter);
}

fetchProducts().then((products) => {
    sessionStorage.setItem("products", JSON.stringify(products));
    renderProducts();
});

function toCardComponent(product) {
    return `
        <div class="col" style="max-height: 450px; min-height: 300px;">
            <div class="card h-100" id="${product._uuid}" style="overflow: hidden; box-shadow: 4px 3px 4px; border-color: black; border-radius: 30px;">
                <img src="${product._imageURL}" alt="${product._title}" style="max-height: 60%;" class="card-img-top" alt="Mercurio">
                <div class="card-body" style="background-color:rgb(64, 111, 173); text-align: center">
                    <p class="card-title" style="text-align: center; font-size: x-large; border-radius: 30px; background-color: rgb(35, 78, 143);"><b>${product._title}</b></p>
                    <p class="card-text" style="text-align: center; border-radius: 10px;"><b>${product._description}</b></p>
                    <button type="button" class="btn btn-primary add-to-cart-btn" data-product-id="${product._uuid}" style="align-self: center;">Añadir a carrito</button>
                </div>
            </div>
        </div>
    `;
}
//------------------------------------------------------------------------------------------------------------------------------------------------
function render(id, html) {
    document.querySelector(`#${id}`).innerHTML = html;
}

const pagination = document.getElementById("product-pagination");

fetchProducts().then((products) => {
    const totalPages = Math.ceil(products.length / 4);
    pagination.innerHTML = "";
    for (let i = 0; i < totalPages; i++) {
        const pageButton = document.createElement("li");
        pageButton.classList.add("page-item");
        pageButton.innerHTML = `<a class="page-link" href="#" data-page="${i}" style="background-color: rgb(54, 46, 46); border-color: rgb(0, 0, 0);">${i + 1}</a>`;
        pagination.appendChild(pageButton);
    }
});

renderProducts();

//-----------------------------------------------------------------------------------
function addEventListeners() {
    document.querySelectorAll(".add-to-cart-btn").forEach((btn) => {
        btn.addEventListener("click", function () {
            const productId = this.dataset.productId;
            const quantity = 1;
            addToCart(productId, quantity);
            showAddModal(productId);
        });
    });
}

pagination.addEventListener("click", (e) => {
    e.preventDefault();
    const target = e.target;
    if (target !== e.currentTarget) {
        const page = parseInt(target.dataset.page);
        renderProducts(page);
    }
});

function showAddModal(productId) {
    $("#cartModal").modal("show");
    $("#productId").val(productId);
}

let globalProductId;

$(document).on("click", ".add-to-cart-btn", function () {
    globalProductId = $(this).data("product-id");
    showAddModal(globalProductId);
});

$(document).on("click", "#addToCartBtn", function () {
    const quantity = parseInt($("#quantity").val());
    const productId = globalProductId;

    fetch(`http://localhost:3000/products/cart/${productId}`, {
        method: "POST",
        body: JSON.stringify({ amount: quantity }),
    })
        .then((response) => {
            if (!response.ok) {
                throw new Error("Failed to add product to cart");
            }
            $("#cartModal").modal("hide");
            Swal.fire({
                icon: "success",
                title: "Success!",
                text: `${quantity} products have been added to the cart.`,
                showConfirmButton: false,
                timer: 1500,
            });
        })
    });
