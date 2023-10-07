import axios from "axios";
import {useEffect} from "react";

export default function Join() {

    function auth() {
        let isvaled = validateForm();

        console.log('Join auth!! >> ', isvaled);
        if(isvaled == false) { return; }
        axios.post('/api/auth/join', {
            //post로 값을 넣어주기.
            id: dom.id.value
            , name : dom.name.value
            , email : dom.email.value
            , password : dom.password.value
            , phoneNumber: dom.phoneNumber.value
            , address : dom.address.value
            , gender : dom.gender.value
            , birthDate: dom.birthDate.value
            , profileImage: dom.profileImage.value
        })
            .then((res) => {
                    console.log(res);
                    alert(res.data.msg);
                    if (res.status === 200) {
                        //console.log("회원가입 성공 {}" )
                    }
            });
    }

    // 에러 메시지를 표시하고 포커스를 설정하는 함수
    function showAlertAndFocus(element, message) {
        alert(message);
        element.focus();
    }

    // 입력 필드가 비어 있는지 검증하는 함수
    function validateForm(){
        let firstErrorField = null; // 첫 번째 에러가 발생한 필드를 저장할 변수
        let errorMessage = ''; // 에러 메시지를 저장할 변수
        console.log('1');
        for (let i = 0; i < dom.list.length; i++) {
            console.log(dom.list[i]);
            if (dom.list[i].value.trim() === '') {
                if (firstErrorField === null) {
                    firstErrorField = dom.list[i]; // 최초의 에러 발생 필드를 저장
                    errorMessage = `${dom.list[i].id} 값이 없습니다.`; // 최초 에러 메시지 저장
                }
            }
        }
        console.log('2');
        if (errorMessage !== '' && firstErrorField !== null) {
            // 최초 에러 발생 필드와 에러 메시지를 알림 창에 표시
            showAlertAndFocus(firstErrorField, errorMessage);
            return false;
        }
        return true;
    }

    let dom;
    //수행할 코드
    useEffect(() => {
        dom = {
            joinBtn : document.getElementById('joinBtn')
            , id : document.getElementById('id')
            , name : document.getElementById('name')
            , email : document.getElementById('email')
            , password : document.getElementById('password')
            , phoneNumber : document.getElementById('phoneNumber')
            , address : document.getElementById('address')
            , gender : document.getElementById('gender')
            , birthDate : document.getElementById('birthDate')
            , profileImage : document.getElementById('profileImage')
            , list : document.querySelectorAll('.form-control-valid')
        }

        dom.joinBtn.addEventListener('click', auth);
    })

    return (
        <div>
            Join<br/>
            <h2 className="text-center">가입</h2>
            <div className="form-group">
                <label htmlFor="id">아이디</label>
                <input type="text" className="form-control-valid" id="id" name="id" required></input>
            </div>
            <div className="form-group">
                <label htmlFor="name">이름</label>
                <input type="text" className="form-control-valid" id="name" name="name" required></input>
            </div>
            <div className="form-group">
                <label htmlFor="email">이메일</label>
                <input type="email" className="form-control-valid" id="email" name="email" required></input>
            </div>
            <div className="form-group">
                <label htmlFor="password">비밀번호</label>
                <input type="password" className="form-control-valid" id="password" name="password" required></input>
            </div>
            <div className="form-group">
                <label htmlFor="phoneNumber">전화번호</label>
                <input type="tel" className="form-control-valid" id="phoneNumber" name="phoneNumber"></input>
            </div>
            <div className="form-group">
                <label htmlFor="address">주소</label>
                <input type="text" className="form-control-valid" id="address" name="address"></input>
            </div>
            <div className="form-group">
                <label htmlFor="gender">성별</label>
                <select className="form-control-valid" id="gender" name="gender">
                    <option value="male">남성</option>
                    <option value="female">여성</option>
                    <option value="other">기타</option>
                </select>
            </div>
            <div className="form-group">
                <label htmlFor="birthDate">생년월일</label>
                <input type="date" className="form-control-valid" id="birthDate" name="birthDate" />
            </div>
            <div className="form-group">
                <label htmlFor="profileImage">프로필 이미지</label>
                <input type="file" className="form-control-file" id="profileImage" name="profileImage"></input>
            </div>
            <button id="joinBtn" type="button" className="btn btn-primary">가입하기</button>

        </div>

    )
}
