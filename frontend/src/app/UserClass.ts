export class UserClass {

  id: number;
  name: string;
  username: string;
  email: string;
  password: string;
  roles:
    [{ id: number; name: string }]



  constructor(id: number, name: string, username: string, email: string, password: string, roles: [{ id: number; name: string }]) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }
}
