// register.html 의 form 에 있는 버튼을 눌렀을때 실행되는 함수
function regist() {
  // 각 form 의 input 에 입력된 값들을 css 선택자를 이용하여 가져오기
  let id = document.querySelector("#id").value;
  let password = document.querySelector("#password").value;
  let name = document.querySelector("#name").value;
  let email = document.querySelector("#email").value;
  let age = document.querySelector("#age").value;

  // user 생성
  const user = {
    id: id,
    password: password,
    name: name,
    email: email,
    age: age,
  };

  // user 정보 출력
  console.log(user);
}

function jjim() {
  let jjimButtons = document.querySelectorAll(".jjim");

  // 선택한 버튼 배열을 forEach() 메서드를 활용하여 순회합니다.
  jjimButtons.forEach((button) => {
    // 각 버튼에 이벤트 리스너를 등록합니다.
    button.addEventListener("click", function () {
      // 버튼을 클릭했을 때 호출될 handler 함수를 정의합니다.
      // 이 함수에서는 해당 영화에 대한 정보를 console.log를 이용하여 출력합니다.
      // 각 버튼이 속한 영화의 정보를 가져와서 출력합니다.
      let movieItem = button.closest(".list-item"); // 부모 요소 중 가장 가까운 '.list-item'을 찾습니다.
      let movieName = movieItem.querySelector(".movie-name").textContent;
      let movieGenre = movieItem.querySelector(".movie-genre").textContent;
      let movieDirector =
        movieItem.querySelector(".movie-director").textContent;
      let movieTime = movieItem.querySelector(".movie-time").textContent;
      console.log("영화 이름:", movieName);
      console.log("장르:", movieGenre);
      console.log("감독:", movieDirector);
      console.log("상영 시간:", movieTime);
      console.log("찜");
      // 추가적으로 필요한 정보가 있다면 해당 버튼의 부모 요소를 통해 가져와서 출력할 수 있습니다.
    });
  });
}

function jjim2() {
  let jjimButtons2 = document.querySelectorAll(".jjim");
  jjimButtons2.forEach((button) => {
    button.addEventListener("click", function (handler) {
      let movieItem2 = button.parentElement.innerText;
      console.log(movieItem2);
    });
  });
}
