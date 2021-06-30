<template>
  <div>
    <!-- 카테고리 Dropdown -->
    <div id="category_dropdown">
      <!-- 1 depth -->
      <div class="dropdown" style="display: inline-block">
        <button
          class="btn btn-secondary dropdown-toggle"
          type="button"
          id="dropdownMenu2"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          Dropdown
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
          <li><button class="dropdown-item" type="button">Action</button></li>
          <li>
            <button class="dropdown-item" type="button">Another action</button>
          </li>
          <li>
            <button class="dropdown-item" type="button">
              Something else here
            </button>
          </li>
        </ul>
      </div>
      >
      <!-- 2 depth -->
      <div class="dropdown" style="display: inline-block">
        <button
          class="btn btn-secondary dropdown-toggle"
          type="button"
          id="dropdownMenu2"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          Dropdown
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
          <li><button class="dropdown-item" type="button">Action</button></li>
          <li>
            <button class="dropdown-item" type="button">Another action</button>
          </li>
          <li>
            <button class="dropdown-item" type="button">
              Something else here
            </button>
          </li>
        </ul>
      </div>
      >
      <!-- 3 depth -->
      <div class="dropdown" style="display: inline-block">
        <button
          class="btn btn-secondary dropdown-toggle"
          type="button"
          id="dropdownMenu2"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          Dropdown
        </button>
        <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
          <li><button class="dropdown-item" type="button">Action</button></li>
          <li>
            <button class="dropdown-item" type="button">Another action</button>
          </li>
          <li>
            <button class="dropdown-item" type="button">
              Something else here
            </button>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'itemDetail',
};
</script>

<style scoped>
#category_dropdown {
  width: 100%;
  height: 50px;
  text-align: left;
}
</style>
