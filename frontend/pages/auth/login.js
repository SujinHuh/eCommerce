import axios from "axios";
import {useEffect} from "react";

export default function Login() {

    function auth() {
        console.log('auth!!');
        axios.post('/api/auth/login', {id:'param'})
            .then((res) => {
                    console.log(res);
            });
    }

    //수행할 코드
    useEffect(() => {
        let dom = {
            id : {
                loginBt : document.getElementById('loginBt')
            }
        }

        dom.id.loginBt.addEventListener('click', auth);
    })

    return (
        <div>
            login<br/>
            <button id='loginBt'>로그인</button>
        </div>
    )
}
