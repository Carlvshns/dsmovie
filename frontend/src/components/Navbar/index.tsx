import {ReactComponent as GithubIcon} from 'assets/img/github.svg';
import './style.css';

function Navbar(){
    return(
        <header>
      <nav className="container">
        <div className="dsmovie-nav-content">
          <h1>DSMovie</h1>
          <div className="dsmovie-contact-container">
          <a href="https://github.com/Carlvshns"><GithubIcon/></a>
            <p className="dsmovie-contact-link">/carlvshns</p>
          </div>
        </div>
      </nav>
    </header>
    );
}

export default Navbar;