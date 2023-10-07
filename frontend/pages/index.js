import Link from 'next/link'
export default function Index() {

    return (
        <div>
            <div>
                여기는 index 입니다.
            </div>

            <Link href="/auth/login">
                login
            </Link>
            <hr/>
            <Link href="/link2">
                link2
            </Link>
        </div>
    )
}
