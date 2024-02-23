import hyRequest from "../request/index.js";

//0:"前端开发"
//1:"服务端相关"
//2:"Java"
//3:"Python"
//4:"数据库"
// -----------------------------------------卡片
export function getcourselist() {
  return hyRequest.get({
    url: "/course/list",
  });
}
export function getfrontlist() {
  return hyRequest.get({
    url: "/course/frontend",
  });
}
export function getservelist() {
  return hyRequest.get({
    url: "/course/backend",
  });
}
export function getjavalist() {
  return hyRequest.get({
    url: "/course/java",
  });
}
export function getpythonlist() {
  return hyRequest.get({
    url: "/course/python",
  });
}
export function getsqllist() {
  return hyRequest.get({
    url: "/course/database",
  });
}

export function getAllfathertitle() {
  return hyRequest.get({
    url: "/course/about",
  });
}
