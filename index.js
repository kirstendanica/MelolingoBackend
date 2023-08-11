const express = require("express");
const app = express();

app.get("/", (req, res) => {
  res.send("Welcome to the Melolingo");
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Server is listening on port ${PORT}`);
});