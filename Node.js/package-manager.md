<h3>Node Package Manager</h3>

- 다른 사람들이 만든 소스 코드들을 모아둔 저장소
- 이미 있는 기능을 다시 구현할 필요가 없어 효율적

<br>
<h3>package.json</h3>

- 현재 프로젝트에 대한 정보와 사용 중인 패키지에 대한 정보를 담은 파일
- 노드 프로젝트 시작 전 package.json부터 만들고 시작함(`npm init`)
- "scripts"는 터미널에 치는 명령어에 별명을 붙이는 것(`npm run [스크립트명]`으로 스크립트 실행)
- "dependencies"는 배포할 때까지 쓰이는 패키지 저장, "devDependencies"는 개발할 때만 쓰이는 패키지 저장(`--save-dev` 또는 `-D`)
- `--global` 또는 `-g`로 모든 프로젝트와 콘솔에서 패키지를 사용할 수 있으나(예. `rimraf node_modules`), dependencies나 devDependencies에 기록 안 됨
- `npx`로 <u>글로벌 설치 없이</u> 글로벌 명령어 사용 가능(예. `npx rimraf node_modules`)

<br>
<h3>노트 패키지 버전</h3>

- 노드 패키지의 버전은 SemVer(유의적 버저닝) 방식을 따름
- Major(주 버전), Minor(부 버전), Patch(수 버전)
- Major는 하위 버전과 호환되지 않은 수정 사항이 생겼을 때, Minor는 하위 버전과 호환되는 수정 사항이 생겼을 때, Patch는 기능에 버그를 해결했을 때 올림
- 패키지 업데이트 시 `^`은 minor 버전까지만, `~`은 patch 버전까지만 업데이트 됨
- `@latest`는 최신을 의미, `@next`로 가장 최신 배포판 사용 가능, `@[특정버전]`도 가능
- [CLI commands](https://docs.npmjs.com/cli/v9/commands)

<br>
<h3>참고</h3>

Node.js 교과서 - 기본부터 프로젝트 실습까지
