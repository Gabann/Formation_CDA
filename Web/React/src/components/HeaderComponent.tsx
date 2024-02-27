import {routes} from "../router/router.tsx";
import {NavLink} from "react-router-dom";
import styles from "../header.module.css";

export function HeaderComponent() {
	return (
		<header>
			<nav className={styles.nav}>
				<ul className={styles.ul}>
					{routes.sort((a, b) => a.path.localeCompare(b.path)).map(({path}) => {
						const name = path.substring(1, 2).toUpperCase() + path.substring(2);
						return (
							<NavLink key={path} to={path}>
								<li className={styles.li}>
									{name}
								</li>
							</NavLink>
						);
					})}
				</ul>
			</nav>
		</header>
	);
}