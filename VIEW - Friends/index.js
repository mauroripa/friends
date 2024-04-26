function toggleDropdown() {
    let dropdown = document.getElementById("dropdown-content");
    if (dropdown.classList.contains("dropdown-hidden")) {
      dropdown.classList.remove("dropdown-hidden");
    } else {
      dropdown.classList.add("dropdown-hidden");
    }
  }

  