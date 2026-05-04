const  usernameInput = document.querySelector('.username-input');
const passwordInput = document.querySelector('.password-input');
const loginButton = document.querySelector('.login-button');
const errorMessage = document.querySelector('.message');
const  correctUsername = 'admin';
const  correctPassword = 'password';
  loginButton.addEventListener('click',function () {
      const inputUsername = usernameInput.value.trim();//trim消除空格
      const inputPassword = passwordInput.value.trim();
      if (!inputUsername || !inputPassword){
          updateui('Please enter both username and password', 'error')
          return;
      }
      if (inputUsername === correctUsername && inputPassword === correctPassword) {
         updateui('Login successful', 'success')
         setTimeout(()=>{
             window.location.href = '学习.html';
         },2000)
      } else {
          updateui('Invalid username or password', 'error')
      }

  });
    function updateui(text,type ){
        errorMessage.textContent = text;
        errorMessage.className = "errormessage"+type;
    }