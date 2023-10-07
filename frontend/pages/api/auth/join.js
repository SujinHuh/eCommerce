// Next.js API route support: https://nextjs.org/docs/api-routes/introduction

import restApi from '/src/utils/RestApi';


export default async function handler(request, response) {
    console.log("Join START >> ", request.body);


let msg;
    await restApi.post('/member/join', request.body)
            .then((res) => {
                console.log(res.response.data);
                msg = res.response.data;
            })
            .catch((err) => {
                msg = err;
            });
    response.status(200).json({msg : msg});
}
