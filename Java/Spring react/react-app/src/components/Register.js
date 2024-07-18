import React, {useEffect, useState} from 'react';
import {useNavigate} from 'react-router-dom';
import authService from '../services/authService';

const Register = () => {
	const navigate = useNavigate();
	const [roles, setRoles] = useState([]);
	const [userData, setUserData] = useState({
		name: '', // Assurez-vous que ce n'est pas undefined
		email: '', // Assurez-vous que ce n'est pas undefined
		password: '', // Assurez-vous que ce n'est pas undefined
		roles: [], // Une valeur par défaut, pour éviter undefined
	});

	const handleChange = (e) => {
		const {name, value, options} = e.target;
		if (name === 'roles' && options) {
			const values = Array.from(options).filter(option => option.selected).map(option => parseInt(option.value));
			setUserData(prevState => ({
				...prevState,
				[name]: values,
			}));
		} else {
			setUserData(prevState => ({
				...prevState,
				[name]: value,
			}));
		}
	};

	useEffect(() => {
		authService.getAllRoles()
			.then(response => {
				console.log(response);
				setRoles(response.data);
			})
			.catch(error => {
			});
	}, []);

	const handleSubmit = async (e) => {
		e.preventDefault();
		try {
			const {name, email, password, roles} = userData;
			await authService.register(name, email, password, roles);
			console.log('User registered successfully');
			navigate('/login'); // Rediriger vers la page de connexion après l'inscription réussie
		} catch (error) {
			console.error('Error registering user:', error);
		}
	};

	return (
		<div className="container mt-5">
			<h2>Inscription</h2>
			<form onSubmit={handleSubmit}>
				<div className="mb-3">
					<label htmlFor="name" className="form-label">Nom</label>
					<input
						type="text"
						className="form-control"
						id="name"
						name="name"
						value={userData.name}
						onChange={handleChange}
						required
					/>
				</div>
				<div className="mb-3">
					<label htmlFor="email" className="form-label">Email</label>
					<input
						type="email"
						className="form-control"
						id="email"
						name="email"
						value={userData.email}
						onChange={handleChange}
						required
					/>
				</div>
				<div className="mb-3">
					<label htmlFor="password" className="form-label">Mot de passe</label>
					<input
						type="password"
						className="form-control"
						id="password"
						name="password"
						value={userData.password}
						onChange={handleChange}
						required
					/>
				</div>
				<div className="mb-3">
					<label htmlFor="role" className="form-label">Rôle</label>
					<select
						className="form-control"
						id="roles"
						name="roles"
						value={userData.roles}
						onChange={handleChange}
						multiple
						required
					>
						{roles.map((role) => (
							<option key={role.id} value={role.id}>
								{role.role}
							</option>
						))}
					</select>
				</div>
				<button type="submit" className="btn btn-primary">S'inscrire</button>
			</form>
		</div>
	);
};

export default Register;
