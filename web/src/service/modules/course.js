import hyRequest from "../request/index.js";

// -----------------------------------------卡片
export function getcourselist() {
  return hyRequest.get({
    url: "/course/list",
  });
}
