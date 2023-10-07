// Next.js API route support: https://nextjs.org/docs/api-routes/introduction

import restApi from '/src/utils/RestApi';


export default async function handler(request, response) {
    console.log(request.body.id);

    await restApi.post('/member/login', 'id=adsd&password=dasdas')
            .then((res) => {
                console.log(res.data);
            })
    response.status(200).json({status : 'status'});
}
